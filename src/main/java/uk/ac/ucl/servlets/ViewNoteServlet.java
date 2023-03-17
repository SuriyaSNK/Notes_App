package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/viewnote.html")
public class ViewNoteServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int noteId = Integer.parseInt(request.getParameter("key1")) - 1;
        Model model = ModelFactory.getModel();
        String noteContent = String.valueOf(model.getContent(noteId));
        String imageUrl = String.valueOf(model.getImageUrl(noteId));

        request.setAttribute("noteContent", noteContent);
        request.setAttribute("imageUrl", imageUrl);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/viewNote.jsp");
        dispatch.forward(request, response);
    }
}
