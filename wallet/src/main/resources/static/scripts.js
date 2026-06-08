// scripts.js

// Function to format a date string in 'YYYY-MM-DD HH:MM:SS' format
function formatDate(dateString) {
    // Log the date string to check what we're receiving
    console.log('Raw date string:', dateString);
    
    // Ensure the date string is valid
    if (!dateString) return 'Invalid Date';
    
    // Create a Date object from the date string
    const date = new Date(dateString);
    
    // Check if the date is valid
    if (isNaN(date.getTime())) return 'Invalid Date';
    
    // Define formatting options
    const options = {
        year: 'numeric',
        month: '2-digit',
        day: '2-digit',
        hour: '2-digit',
        minute: '2-digit',
        second: '2-digit',
        hour12: false // Use 24-hour time
    };
    
    // Format the date
    return date.toLocaleString('en-US', options);
}

// Update the content of each date-cell element with formatted date
document.addEventListener('DOMContentLoaded', function () {
    document.querySelectorAll('.date-cell').forEach(function (cell) {
        const date = cell.dataset.date;
        console.log('Date from data attribute:', date);
        if (date) {
            cell.textContent = formatDate(date);
        }
    });
});


