package uk.ac.ucl.servlets;

import com.google.gson.reflect.TypeToken;
import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;
import uk.ac.ucl.model.Note;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

@WebServlet("/noteRenamed.html")
public class RenameNoteServlet extends HttpServlet
{
    public static Type type = new TypeToken<List<Note>>(){}.getType();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        Model model = ModelFactory.getModel();
        Integer noteId = Integer.valueOf(request.getParameter("noteId"));
        String noteName = request.getParameter("noteName");

        model.renameNote(noteId, noteName);

        ServletContext context = getServletContext();
        RequestDispatcher dispatch = context.getRequestDispatcher("/noteRenamed.jsp");
        dispatch.forward(request, response);

    }
}
