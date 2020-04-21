# INF-124-Project 1

URL Address: http://circinus-5.ics.uci.edu:8080/project1/homepage.html

Group: Minh To (79292595), Huy Duc Vo (17903562), Kuljit Singh (73652462)
E-commerce Business: Chocolate Factory (Chocoholics) #selling various types of chocolates
Categories: White Chocolate, Dark Chocolate, Milk Chocolate

General Layout Design: 
The website consists of 4 unique pages (Homepage, About Us, variations of Product pages, variations of Individual product pages)
All of the pages have the same navigation bar at the top
Homepage: 
Slide-Show that contains 4 slides: About Us, and categories of chocolate.  
3 panels that display unique images for the categories of chocolate
Product Pages: 
The Best Seller section displays the top 3 best selling products with the images linked to that corresponding individual product page.
The Chocolate Products section displays 10 different chocolates of the corresponding category in a table format with each cell having its own name and prices. Both the images and the brand name takes the users to the corresponding individual product page.
Individual Product Description Pages: 
3 different images with price and description about the specific chocolate. 
Underneath the description is the form to order the product. 

Requirements Specified: 
1. An overview of your business, the products you sell, the management team, and any other information that you think makes sense for the customers to know about your company.
Stated in the (About Us) page

2. Display a list of products (at least 10) available for sale in a table with multiple rows and columns, where each product is shown within a separate cell.
Demonstrated in the Product pages located in the navbar (White Chocolate, Dark Chocolate, Milk Chocolate)

3. Display an image for each product available for sale in each cell.
Demonstrated in the Product pages located in the navbar (White Chocolate, Dark Chocolate, Milk Chocolate)

4. Display the price and other key information (e.g., color, material, etc.) associated with each product in the corresponding table cell.
Demonstrated in the Product pages located in the navbar (White Chocolate, Dark Chocolate, Milk Chocolate)

5. The user should be able to choose a product from this table by clicking on the corresponding image, which should lead to a new page that provides additional details about the product, e.g., more images, detailed descriptions, etc. 
Demonstrated in the Product pages located in the navbar (White Chocolate, Dark Chocolate, Milk Chocolate)

6. On the detailed description page, the user should be able to order a product by filling a form. The form should allow the user to enter the product identifier, quantity, first name, last name, phone number, shipping address, shipping method (e.g., overnight, 2-days expedited, 6-days ground), credit card information, and anything else that you think makes sense for your business.
The detailed description and form are shown after clicking on the specific chocolate in the Products Page (located in the navbar (White Chocolate, Dark Chocolate, Milk Chocolate)). 


7. Upon submitting the form, the website should send an email with the purchase order information included in the body of the email. Note that to really send an email, one needs to connect to the SMTP server, which is not possible with the client-side software. Thus, this requirement simply requires bringing up the email client with the purchase order information included in the body of the email and allowing the user to send the email. 
The email client will bring up the purchase order information when clicking “Submit” after filling out the form properly. 

8. Before submitting the form, it should be checked for proper formatting, including whether all fields are filled properly, whether the phone number, address, and credit card are properly formatted, etc. An alarm should be raised if a field is empty or not properly formatted to prevent the submission of bad data. 
The form is checked in the (orderCheck.js) file. In this file, it checks if any input field is empty or not properly formatted. For the fields that require a string, it checks if no integer is inputted and vice versa. It checks for specific lengths for the phone number, zip code, credit card number, and CVV. 

9. Your website should use CSS to specify at least 10 stylistic properties for your website, such as the background for your table, the color and size of your font, the size of your images, and other stylistic preferences you may have.
More than 10 CSS properties were used. Check out the CSS files located in the CSS folder for more details.

10. Provide the ability to track the mouse movement, such that when the mouse moves over a product image, the size of the image is increased, and when the mouse moves out, the size of the image is returned back to normal. This feature can be implemented on either the page that displays the various products, or on the pages that show the details of each product, or both.
This feature was done on the Product pages located in the navbar. The images increase its size when the mouse hovers over them.

11. Print the name and the StudentID of group members on the webpage.
This information is shown at the bottom section “Our Team” on the About Us page
