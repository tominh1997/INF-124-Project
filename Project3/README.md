# INF-124-Project 3

Group Members: Minh To (79292595), Huy Duc Vo (17903562), Kuljit Singh (73652462)
E-commerce Business: Chocolate Factory (Chocoholics) #selling various types of chocolates
Categories: White Chocolate, Dark Chocolate, Milk Chocolate
MYSQL's Password: "" (basically blank so just press entere when prompted)

1. All the servlets used for this project can be found in the src folder. 
2. All other files can be found in the WebContent. It is important to note that we kept our front-end and back-end totally separated.
This means that we did not use Writer in the servlet to print out the html, but instead we directly fetched the information from our backend
by using JSP (consists of mostly HTML) along with response's attributes. Feel free to check out any JSP files because this is currently the best
practice in the industry :)

1. Include the output of two servlets to create the homepage for your e-commerce site: the first servlet should handle the displaying of the list of products obtained from a backend database, and the second servlet should use session tracking to display the last 5 products that the user has visited (viewed the product details page). In case this number is less than 5, show whatever amount of information you have stored in the session. You are required to use servlet "include" feature to implement this requirement. 
*For this requirement, we used HomepageServlet to include both ProductsServlet (used to fetch products information from DB) and RecentVisitServlet (used to keep track of the last 5 viewed items by the session of the user). These are demonstrated in the homepage. Just click on any of the products and navigate back to the homepage to see the recently viewed items.*

2. Using servlets create a "product details" page. This page should take a product identifier as a parameter and show the product details after getting the relevant information from the database. This page should NOT have an order form, only a button to "Add to Cart". Use servlet "session" to store the products in a shopping cart.
*For this requirement, we used ProductDescriptionServlet which takes in the product's ID (primary key in our DB table) as the parameter to fetch the information including images, prices from our DB to display them on the front-end.
We also linked AddCartServlet with the "Add To Cart" button so that the product on the page will be added to the cart of the session that the user is in.*

3. Using servlets create a "check out" page, which allows the user to place an order. The page should show all the products in the shopping cart and the total price. This page should have a form which will allow the user to do the following:
*For this requirement, we used doGet of the CheckoutServlet to display all products in the shopping cart by the session as well as the total price of the products.
Furthermore, we also used doPost of the CheckoutServlet to link it with the form so that it will "forward" the user to the Order Confirmation page once the user filled in their information and submitted. It will also store the form's information to the DB once the form is submitted.*

HOW TO SETUP:
All you need to do is to import the project into IntelliJ IDEA and run it on Tomcat 8.5. I also included a detailed pdf in the folder that you can follow after you import the project (File => New => Project). Make sure you have the JDBC SQL Driver installed.

