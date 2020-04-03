package action;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public abstract class ActionAnnotation extends HttpServlet {
	public void init() throws ServletException {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	public abstract void initProcess(HttpServletRequest request, HttpServletResponse response);

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		initProcess(request, response);
		String command = request.getRequestURI();
		System.out.println("1:" + command);
		if (command.lastIndexOf("/") != -1) {
			command = command.substring(command.lastIndexOf("/") + 1);
		}
		System.out.println("2:" + command);

		Method[] methods = this.getClass().getMethods();
		String viewPage = null;
		String tempMethod = null;
		try {
			for (Method method : methods) {
				RequestMapping re = method.getAnnotation(RequestMapping.class);

				tempMethod = request.getMethod();
				tempMethod = tempMethod.toUpperCase();
				if (!tempMethod.equals("POST")) {
					tempMethod = "GET";
				}

				if (re != null && re.value().equals(command) && re.method().name().equals(tempMethod))
					viewPage = (String) method.invoke(this, request, response);
			}

		} catch (Throwable e) {
			throw new ServletException(e);
		}
		if (viewPage != null) {
			if (viewPage.startsWith("redirect:")) {
				viewPage = viewPage.replace("redirect:", "");
				response.sendRedirect(request.getContextPath() + viewPage);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
				dispatcher.forward(request, response);
			}
		} else {
			try {
				throw new RequestNotMatch(
						command + "  not requestMapping in " + getClass().getName() + "for " + tempMethod);
			} catch (RequestNotMatch e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException(e);
			}
		}
	}
}

class RequestNotMatch extends Exception {
	RequestNotMatch(String name) {
		super(name);
	}
}