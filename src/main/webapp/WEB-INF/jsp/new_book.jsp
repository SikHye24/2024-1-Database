<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>New Book</title>
</head>
<body>
<h2>Register New Book</h2>
<form action="register_book" method="post">
    <label for="isbn">ISBN:</label>
    <input type="text" id="isbn" name="isbn" required><br>
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required><br>
    <label for="year">Year:</label>
    <input type="number" id="year" name="year" required><br>
    <label for="price">Price:</label>
    <input type="number" id="price" name="price" required><br>

    <h3>Author Information</h3>
    <label for="authorName">Name:</label>
    <input type="text" id="authorName" name="authorName" required><br>
    <label for="authorAddress">Address:</label>
    <input type="text" id="authorAddress" name="authorAddress" required><br>
    <label for="authorUrl">URL:</label>
    <input type="text" id="authorUrl" name="authorUrl"><br>

    <h3>Publisher Information</h3>
    <label for="publisherName">Name:</label>
    <input type="text" id="publisherName" name="publisherName" required><br>
    <label for="publisherAddress">Address:</label>
    <input type="text" id="publisherAddress" name="publisherAddress" required><br>
    <label for="publisherPhone">Phone:</label>
    <input type="text" id="publisherPhone" name="publisherPhone" required><br>
    <label for="publisherUrl">URL:</label>
    <input type="text" id="publisherUrl" name="publisherUrl"><br>

    <h3>Stock Information</h3>
    <label for="warehouseCode">Warehouse Code:</label>
    <input type="text" id="warehouseCode" name="warehouseCode" required><br>
    <label for="stockNum">Stock Number:</label>
    <input type="number" id="stockNum" name="stockNum" required><br>

    <input type="submit" value="Register Book">
</form>
</body>
</html>
