const hamBurger = document.querySelector(".toggle-btn");
const dropdownToggle = document.querySelectorAll(".has-dropdown");

hamBurger.addEventListener("click", function () {
    sidebar.classList.toggle("expand");
});

dropdownToggle.forEach((toggle) => {
    toggle.addEventListener("click", function () {
        const expanded = this.getAttribute("aria-expanded") === "true";
        this.setAttribute("aria-expanded", !expanded);
    });
});