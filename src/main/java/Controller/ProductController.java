@WebServlet("/product")
public class ProductController extends HttpServlet {
    private ProductRepository productRepo = new ProductRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productRepo.getAllProducts();
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String color = request.getParameter("color");
            String description = request.getParameter("description");
            int categoryId = Integer.parseInt(request.getParameter("category_id"));

            Product product = new Product();
            product.setName(name);
            product.setPrice(price);
            product.setQuantity(quantity);
            product.setColor(color);
            product.setDescription(description);
            product.setCategoryId(categoryId);

            productRepo.addProduct(product);
            response.sendRedirect("product");
        } else if ("delete".equals(action)) {
            int productId = Integer.parseInt(request.getParameter("id"));
            productRepo.deleteProduct(productId);
            response.sendRedirect("product");
        } else if ("edit".equals(action)) {
            int productId = Integer.parseInt(request.getParameter("id"));
            Product product = productRepo.getProductById(productId);
            request.setAttribute("product", product);
            RequestDispatcher dispatcher = request.getRequestDispatcher("editProduct.jsp");
            dispatcher.forward(request, response);
        }
    }
}
