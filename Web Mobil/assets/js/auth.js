document.addEventListener("DOMContentLoaded", () => {
    const loginForm = document.getElementById("loginForm");
    const registerForm = document.getElementById("registerForm");

    if (loginForm) {
        loginForm.addEventListener("submit", function (e) {
            e.preventDefault();
            const data = new FormData(loginForm);
            fetch("../php/login.php", {
                method: "POST",
                body: data,
            })
            .then(res => res.text())
            .then(res => {
                if (res === "success") {
                    window.location.href = "../index.html";
                } else {
                    alert("Login gagal: " + res);
                }
            });
        });
    }

    if (registerForm) {
        registerForm.addEventListener("submit", function (e) {
            e.preventDefault();
            const data = new FormData(registerForm);
            fetch("../php/register.php", {
                method: "POST",
                body: data,
            })
            .then(res => res.text())
            .then(res => {
                if (res === "success") {
                    alert("Registrasi berhasil! Silakan login.");
                    window.location.href = "login.html";
                } else {
                    alert("Registrasi gagal.");
                }
            });
        });
    }
});
