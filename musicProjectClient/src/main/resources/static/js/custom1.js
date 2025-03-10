$(document).ready(function () {
    // 1. Khởi tạo datepicker cho #dob
    $("#dob").datepicker({
        dateFormat: "dd/mm/yy", // Định dạng ngày
        changeMonth: true, // Hiển thị chọn tháng
        changeYear: true, // Hiển thị chọn năm
        yearRange: "1900:2025", // Giới hạn năm từ 1900 đến 2025
        maxDate: new Date() // Không cho chọn ngày trong tương lai
    });

    // 2. Xử lý đăng ký (btn_register)
    $("#btn_register").click(function () {
        var user = {
            email: $("#email").val(),
            password: $("#password").val(),
            fullname: $("#fullname").val(),
            dob: $("#dob").val(),
            photo: "https://res.cloudinary.com/dhee9ysz4/image/upload/v1741076584/ypj7xyshwjq9zhuazfq9.webp",
            isActive: true
        };

        $.ajax({
            url: "http://localhost:8085/api/users/register",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(user),
            success: function (response, textStatus, xhr) {
                console.log("Response:", response);
                console.log("Status Code:", xhr.status);

                if (xhr.status === 200 && response.code === 200) {
                    console.log("User registered successfully");

                    // Ẩn modal đăng ký và hiển thị modal OTP
                    $("#myModal").modal("hide");

                    sessionStorage.setItem("registeredEmail", response.result.email);

                    setTimeout(function () {
                        if (typeof bootstrap !== "undefined") {
                            var otpModal = new bootstrap.Modal(document.getElementById("otpModal"));
                            otpModal.show();
                        } else {
                            $("#otpModal").modal("show");
                        }
                    }, 500);
                } else {
                    alert("Registration failed: " + response.message);
                }
            },
            error: function (xhr) {
                if (xhr.responseJSON && xhr.responseJSON.message) {
                    alert("Error: " + xhr.responseJSON.message);
                } else {
                    alert("An unexpected error occurred.");
                }
            }
        });
    });

    // 3. Xử lý xác thực OTP (btn_verify)
    $("#btn_verify").click(function () {
        var otp = $("#otp").val();
        var email = sessionStorage.getItem("registeredEmail");

        if (!email) {
            alert("Error: No registered email found. Please register again.");
            return;
        }

        var requestData = {
            otp: otp,
            email: email
        };

        $.ajax({
            url: "http://localhost:8085/api/users/active-account",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(requestData),
            success: function (response, textStatus, xhr) {
                console.log("Response:", response);
                console.log("Status Code:", xhr.status);

                if (xhr.status === 200 && response.code === 200) {
                    alert("Registration successful! Please log in.");
                    sessionStorage.removeItem("registeredEmail");
                    location.reload();
                } else {
                    alert("Error: " + response.message);
                }
            },
            error: function (xhr) {
                if (xhr.responseJSON && xhr.responseJSON.message) {
                    alert("Error: " + xhr.responseJSON.message);
                } else {
                    alert("An unexpected error occurred.");
                }
            }
        });
    });

    // 4. Xử lý đăng nhập (btnLogin)
    $("#btnLogin").click(function (e) {
        e.preventDefault(); // Ngăn chặn reload form

        let email = $("#emailLogin").val().trim();
        let password = $("#passwordLogin").val().trim();

        if (!email || !password) {
            alert("Please enter email and password.");
            return;
        }

        $.ajax({
            url: "http://localhost:8085/api/users/sign-in",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify({ email: email, password: password }),
            success: function (response) {
                if (response.code === 200) {
                    let result = response.result;

                    sessionStorage.setItem("token", result.token);
                    sessionStorage.setItem("user", JSON.stringify(result));

                    alert("Login successful! Redirecting...");
                    location.reload();
                } else {
                    alert("Login failed: " + response.message);
                }
            },
            error: function (xhr) {
                let errorMessage = xhr.responseJSON ? xhr.responseJSON.message : "Unknown error!";
                alert("Error: " + errorMessage);
            }
        });
    });

    // 5. Xử lý hiển thị profile và thông tin user
    // Ban đầu ẩn profileBtn
    $("#profileBtn").hide();

    // Lấy thông tin user và token từ sessionStorage
    var token = sessionStorage.getItem("token");
    var user = sessionStorage.getItem("user");

    if (token && user) {
        var userData = JSON.parse(user);

        // Ẩn div ms_top_btn chứa các nút đăng ký & đăng nhập (không tính profileBtn)
        $(".ms_top_btn:not(#profileBtn)").hide();

        // Cập nhật text cho profileBtn với fullname của user
        $("#profileBtn a span").text(userData.fullname);

        // Hiển thị profileBtn
        $("#profileBtn").show();

        $("#emailOld").val(userData.email);
        $("#new_fullname").val(userData.fullname);
    }

    // 6. Xử lý thay đổi thông tin và đăng xuất (btn_changeInfo, btn_logOut)
    $("#btn_changeInfo").click(function () {
        let token = sessionStorage.getItem("token");
        if (!token) {
            alert("You are not logged in!");
            return;
        }

        // Lấy thông tin từ input
        let changeInfoData = {
            email: $("#emailOld").val().trim(),
            fullname: $("#new_fullname").val().trim(),
            password: $("#new_password").val().trim(),
            rePassword: $("#re_password").val().trim()
        };

        // Kiểm tra mật khẩu nhập lại có trùng khớp không
        if (changeInfoData.password !== changeInfoData.rePassword) {
            alert("Passwords do not match!");
            return;
        }

        $.ajax({
            url: "http://localhost:8085/api/users/change-info",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(changeInfoData),
            headers: {
                Authorization: "Bearer " + token
            },
            success: function (response) {
                if (response.code === 200) {
                    alert("User info updated successfully!");

                    // Cập nhật lại token và user trong sessionStorage
                    let updatedUser = response.result;
                    sessionStorage.setItem("user", JSON.stringify(updatedUser));
                    sessionStorage.setItem("token", updatedUser.token);

                    location.reload();
                } else {
                    alert(response.message);
                }
            },
            error: function (xhr) {
                let errorMessage = xhr.responseJSON && xhr.responseJSON.message ? xhr.responseJSON.message : "An error occurred!";
                alert("Error: " + errorMessage);
            }
        });
    });

    $("#btn_logOut").click(function () {
        sessionStorage.removeItem("token");
        sessionStorage.removeItem("user");
        alert("Logged out successfully");
        location.reload();
    });
});