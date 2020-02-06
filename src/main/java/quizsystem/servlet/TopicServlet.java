package quizsystem.servlet;

import quizsystem.entity.Topic;
import quizsystem.injector.ApplicationInjector;
import quizsystem.service.TopicService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TopicServlet extends HttpServlet {

    private final TopicService topicService;

    public TopicServlet() {
        this.topicService = ApplicationInjector.getInstance().getTopicService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Topic> topics = topicService.findAll();
        req.setAttribute("topics", topics);
        req.getRequestDispatcher("topics.jsp").forward(req, resp);
    }
}