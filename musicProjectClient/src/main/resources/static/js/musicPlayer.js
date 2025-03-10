document.addEventListener("DOMContentLoaded", function () {
    function loadMusicPlayer() {
        fetch("/music-player") // Gọi API để lấy player
            .then(response => response.text())
            .then(html => {
                document.getElementById("musicPlayerContainer").innerHTML = html;
            })
            .catch(error => console.error("Lỗi khi tải player:", error));
    }

    loadMusicPlayer(); // Tải player khi trang load lần đầu
});
