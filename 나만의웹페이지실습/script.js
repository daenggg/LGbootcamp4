document.addEventListener('DOMContentLoaded', () => {
    const header = document.getElementById('header');
    const searchInput = document.getElementById('searchInput');

    // Scroll Effect for Header
    window.addEventListener('scroll', () => {
        if (window.scrollY > 50) {
            header.classList.add('scrolled');
        } else {
            header.classList.add('scrolled');
            header.classList.remove('scrolled'); // Force redraw bug fix if needed
            if(window.scrollY <= 50) header.classList.remove('scrolled');
        }
    });

    // Search input interaction
    searchInput.addEventListener('focus', () => {
        searchInput.parentElement.style.boxShadow = '0 12px 30px rgba(250, 98, 47, 0.2)';
        searchInput.parentElement.style.border = '1px solid var(--primary-color)';
    });

    searchInput.addEventListener('blur', () => {
        searchInput.parentElement.style.boxShadow = '0 10px 25px rgba(0,0,0,0.15)';
        searchInput.parentElement.style.border = 'none';
    });
});
