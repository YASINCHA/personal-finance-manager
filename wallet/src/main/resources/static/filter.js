// scripts.js

function filterOperations() {
    // Retrieve values from the filter inputs
    const searchInput = document.getElementById('searchInput').value.toLowerCase();
    const typeFilter = document.getElementById('typeFilter').value.toLowerCase();
    const categoryFilter = document.getElementById('categoryFilter').value.toLowerCase();

    // Get all rows in the table body
    const table = document.querySelector('table tbody');
    const rows = table.getElementsByTagName('tr');

    // Loop through each row to check if it matches the filter criteria
    for (let i = 0; i < rows.length; i++) {
        const cells = rows[i].getElementsByTagName('td');
        const operationType = cells[1]?.innerText.toLowerCase() || ""; // Get operation type from the second cell
        const category = cells[2]?.innerText.toLowerCase() || ""; // Get category from the third cell
        const rowText = rows[i].innerText.toLowerCase(); // Get all text in the row

        // Check if the row matches search and filter criteria
        const matchesSearch = rowText.includes(searchInput);
        const matchesType = typeFilter === "" || operationType === typeFilter;
        const matchesCategory = categoryFilter === "" || category === categoryFilter;

        // Show or hide the row based on the match results
        if (matchesSearch && matchesType && matchesCategory) {
            rows[i].style.display = '';
        } else {
            rows[i].style.display = 'none';
        }
    }
}

// Debugging: Log filter status for troubleshooting
console.log("Filter script loaded and ready to function.");

