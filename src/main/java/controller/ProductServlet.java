package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductServlet extends HttpServlet {
    private ProductService product = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateFrom(req, resp);
                break;
            case "edit":
                showEditFrom(req, resp);
                break;
            case "delete":
                showDeleteFrom(req, resp);
                break;
            case "view":
                showViewFrom(req, resp);
                break;
            default:
                listProduct(req, resp);
                break;
        }
    }
//    private void searchProduct(HttpServletRequest req, HttpServletResponse resp) {
//        String search = req.getParameter("search");
//        RequestDispatcher dispatcher;
//        if (product.equals(search)){
//            req.setAttribute("products", product);
//            dispatcher=req.getRequestDispatcher("products/view.jsp");
//        }else {
//            dispatcher = req.getRequestDispatcher("products/error-404.jsp");
//        }
//        try {
//            dispatcher.forward(req,resp);
//        } catch (ServletException | IOException e) {
//            e.printStackTrace();
//        }

    private void showDeleteFrom(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = this.product.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = req.getRequestDispatcher("products/error-404.jsp");
        } else {
            req.setAttribute("products", product);
            dispatcher = req.getRequestDispatcher("products/delete.jsp");
        }
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showViewFrom(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = this.product.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = req.getRequestDispatcher("products/error-404.jsp");
        } else {
            req.setAttribute("products", product);
            dispatcher = req.getRequestDispatcher("products/view.jsp");
        }
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditFrom(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = this.product.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = req.getRequestDispatcher("products/error-404.jsp");

        } else {
            req.setAttribute("products", product);
            dispatcher = req.getRequestDispatcher("products/edit.jsp");
        }
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void listProduct(HttpServletRequest req, HttpServletResponse resp) {
        List<Product> products = this.product.findAll();
        req.setAttribute("products", products);
        RequestDispatcher dispatcher = req.getRequestDispatcher("products/list.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateFrom(HttpServletRequest req, HttpServletResponse resp) {
        List<Product> products = this.product.findAll();
        req.setAttribute("products", products);

        RequestDispatcher dispatcher = req.getRequestDispatcher("products/create.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(req, resp);
                break;
            case "edit":
                updateProduct(req, resp);
                break;
            case "delete":
                deleteProduct(req, resp);
                break;
            default:
                break;
        }

    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));

        Product product = this.product.findById(id);


        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = req.getRequestDispatcher("products/error-404.jsp");
        } else {
            this.product.remove(id);
        }
        try {
            resp.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = (int) (Math.random() * 10000);
        String tensanpham = req.getParameter("tensanpham");
        int giasanpham = Integer.parseInt(req.getParameter("giasanpham"));
        String motasanpham = req.getParameter("motasanpham");
        String nhasanxuat = req.getParameter("nhasanxuat");

        Product product = new Product(id, tensanpham, giasanpham, motasanpham, nhasanxuat);

        this.product.save(product);
        RequestDispatcher dispatcher = req.getRequestDispatcher("products/create.jsp");
        req.setAttribute("message", "New Products was created");
        try {
            resp.sendRedirect("/products");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String tensanpham = req.getParameter("tensanpham");
        int giasanpham = Integer.parseInt(req.getParameter("giasanpham"));
        String motasanpham = req.getParameter("motasanpham");
        String nhasanxuat = req.getParameter("nhasanxuat");
        Product product = new Product();
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = req.getRequestDispatcher("products/error-404.jsp");
        } else {
            product.setId(id);
            product.setTensanpham(tensanpham);
            product.setGiasanpham(giasanpham);
            product.setMotasanpham(motasanpham);
            product.setNhasanxuat(nhasanxuat);
            this.product.update(id, product);
            req.setAttribute("message", "Product information was updated");
            dispatcher = req.getRequestDispatcher("products/edit.jsp");
            try {
                resp.sendRedirect("/products");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }



    }
