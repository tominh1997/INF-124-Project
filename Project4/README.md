# INF-124-Project 4

Group Members: Minh To (79292595), Huy Duc Vo (17903562), Kuljit Singh (73652462)
E-commerce Business: Chocolate Factory (Chocoholics) #selling various types of chocolates
Categories: White Chocolate, Dark Chocolate, Milk Chocolate

1. Using JSP reimplement the product list page. This is the page that contains the list of your products.
*All the JSP files can be found in the WEB-CONTENT folder inside of Client folder*

2. Create REST services to allow for interaction with the order and product resources stored in your application database. You will need to implement services that use the following verbs
*
     i.   GET - We implemented 2 functions within our REST service to retrieve our products by type and individual product by their ID
     Request URL for products by type: http://localhost:8080/chocoholic_REST_war_exploded/products/{type}
     Sample Response:
     {
     	"product1": {
     	"name": "Crunch",
     	"price": $10,
     	"description: abc"
     	},
     	"product2": {
     	"name": "Hershey",
     	"price": $10,
     	"description: abc"
     	}
     }

     Request URL for individual product by their ID: http://localhost:8080/chocoholic_REST_war_exploded/products/product/{id}
     Sample Response:
     {
     	"name": "Crunch",
     	"price": $10,
     	"description: abc"
     }


     ii.  PUT
     Request URL for checkout: http://localhost:8080/chocoholic_REST_war_exploded/checkout
     Sample Response:
     {
     	"name": "Minh To",
     	"subtotal": "$20",
     	"shipping": "$1",
     	"totalBeforeTax": "$21",
     	"tax": "0.8",
     	"grandTotal": "$23"
     }

*		

3. You will now need to replace all the database interactions in your web application with REST calls. Your web application will now act as a REST client and retrieve the MySQL data indirectly through the new RESTful web service. That is, you will have two applications: (1) a backend application that provides RESTful APIs that essentially exposes the available operations in your database, and (2) an application that is the client of the RESTful APIs, generates the HTML pages, and handles requests from the user.  While in this assignment you are developing both applications yourself, in practice, each application may be developed by a separate company. For example, companies such as Google, Amazon, and PayPal may develop the RESTful APIs that allow others to leverage their services in building their web applications. 

*Check out DatabaseUtils within src directory inside of chocoholic_REST folder where all of our datbase interactions reside at*

