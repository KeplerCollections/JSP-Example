package bean;

import com.sun.org.apache.bcel.internal.generic.GOTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        switch (request.getParameter("value")) {
            case "1":
                String email = request.getParameter("email");
                String name = request.getParameter("name");
                String password = request.getParameter("password");

                User bean = new User();
                bean.setName(name);
                bean.setEmail(email);
                bean.setPass(password);
                request.setAttribute("bean", bean);

                boolean status = Dao.insert(bean);
                if (status) {
                    dispatchRequest(request, response, "success.jsp");
                } else {
                    dispatchRequest(request, response, "error.jsp");

                }
                break;
            case "2":
                fetchRecord(request, response);
                break;
            case "3":
                boolean deleteStatus = Dao.delete(Integer.parseInt(request.getParameter("id")));
                if (deleteStatus) {
                    fetchRecord(request, response);
                } else {
                    dispatchRequest(request, response, "error.jsp");
                }
                break;
            default:
                break;
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    private void dispatchRequest(HttpServletRequest request, HttpServletResponse response, String string) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher(string);
            rd.forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fetchRecord(HttpServletRequest request, HttpServletResponse response) throws UnsupportedOperationException {
        List<User> values = Dao.fetch();
        request.setAttribute("values", values);
        dispatchRequest(request, response, "list.jsp");
    }

}
