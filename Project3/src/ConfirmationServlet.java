import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ConfirmationServlet", urlPatterns = "/api/confirmation")
public class ConfirmationServlet extends HttpServlet {
    private static final long serialVersionUID = 2L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json"); // Response mime type
        JsonObject jsonObject = new JsonObject();
        PrintWriter out = response.getWriter();
        try{
            Gson g = new Gson();
            HttpSession session = request.getSession();
            HashMap<String,String> user = (HashMap<String, String>) session.getAttribute("user");
            ArrayList<Item> cart = (ArrayList<Item>)session.getAttribute("cart");

            jsonObject.addProperty("items", g.toJson(cart));
            jsonObject.addProperty("user", g.toJson(user.values()));


            out.write(jsonObject.toString().replace("\\", "").replace("\"[{", "[{").replace("}]\"", "}]"));


            response.setStatus(200);
        }catch (Exception e){
            // write error message JSON object to output
            jsonObject.addProperty("message", e.getMessage());
            out.write(jsonObject.toString());
            e.printStackTrace();
            // set reponse status to 500 (Internal Server Error)
            response.setStatus(500);
        }


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request,response);
    }

}
