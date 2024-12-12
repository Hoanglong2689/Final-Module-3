<form action="product" method="post">
    <input type="hidden" name="action" value="add">
    <input type="text" name="name" required placeholder="Product Name">
    <input type="number" name="price" required placeholder="Price" min="10000000">
    <input type="number" name="quantity" required placeholder="Quantity">
    <select name="color" required>
        <option>Red</option>
        <option>Blue</option>
        <option>Black</option>
        <option>White</option>
        <option>Yellow</option>
    </select>
    <textarea name="description" required placeholder="Description"></textarea>
    <select name="category_id" required>
        <!-- Populate categories here -->
    </select>
    <button type="submit">Create</button>
</form>
