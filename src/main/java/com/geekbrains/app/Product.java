package com.geekbrains.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Product", urlPatterns = "/show_page")
public class Product extends HttpServlet {
    private int id;
    private String title;
    private String cost;
    private static Logger logger = LoggerFactory.getLogger(Product.class);

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCost() {
        return cost;
    }
    public void settId(int id) {
         this.id=id;
    }
    public void setTitle(String title) {
         this.title=title;
    }
    public void setCost(String cost) {
        this.cost=cost;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        Product product = new Product();
        for (int i = 1; i<11; i++) {
            product.settId(i);
            product.setTitle("продукт "+ i);
            product.setCost(i*5 + "р");
            resp.getWriter().printf("<h1>" + product.getId() + "</h1>");
            resp.getWriter().printf("<h1>" + product.getTitle() + "</h1>");
            resp.getWriter().printf("<h1>" + product.getCost() + "</h1>");
            resp.getWriter().printf("</body></html>");
        }
            resp.getWriter().printf("</body></html>");
            resp.getWriter().close();

    }

    @Override
    public void init() throws ServletException {
        logger.debug("Init");
    }
}

