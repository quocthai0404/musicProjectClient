let swiperInstance;

async function fetchSongs() {
    try {
        const response = await fetch('http://localhost:8085/api/songs/getAll?page=0&size=5');
        const data = await response.json();

        const songList = document.querySelector(".swiper-wrapper"); // Chọn container của Swiper
        songList.innerHTML = ""; // Xóa nội dung cũ

        data.content.forEach(song => {
            let songItem = document.createElement("div");
            songItem.classList.add("swiper-slide");

            songItem.innerHTML = `
                <div class="ms_rcnt_box">
                    <div class="ms_rcnt_box_img">
                        <img src="${song.photo}" alt="${song.name}" style="width: 150px; height: 150px;">
                        <div class="ms_main_overlay">
                            <div class="ms_box_overlay"></div>
                            <div class="ms_more_icon">
                                <img src="images/svg/more.svg" alt="">
                            </div>
                            <ul class="more_option">
                                <li><a href="#"><span class="opt_icon"><span class="icon icon_fav"></span></span>Add To Favourites</a></li>
                                <li><a href="#"><span class="opt_icon"><span class="icon icon_queue"></span></span>Add To Queue</a></li>
                                <li><a href="#"><span class="opt_icon"><span class="icon icon_dwn"></span></span>Download Now</a></li>
                                <li><a href="#"><span class="opt_icon"><span class="icon icon_playlst"></span></span>Add To Playlist</a></li>
                                <li><a href="#"><span class="opt_icon"><span class="icon icon_share"></span></span>Share</a></li>
                            </ul>
                            <div class="ms_play_icon">
                                <img src="images/svg/play.svg" alt="">
                            </div>
                        </div>
                    </div>
                    <div class="ms_rcnt_box_text">
                        <h3><a href="#">${song.name}</a></h3>
                        <p>${song.artists.map(a => a.stageName).join(", ")}</p>
                    </div>
                </div>
            `;

            songList.appendChild(songItem);
        });

        // 🛑 Hủy Swiper cũ nếu đã tồn tại
        if (swiperInstance) {
            swiperInstance.destroy(true, true);
        }

        // ✅ Khởi tạo lại Swiper sau khi cập nhật DOM
        swiperInstance = new Swiper(".swiper-container", {
            loop: true,
            navigation: {
                nextEl: ".swiper-button-next",
                prevEl: ".swiper-button-prev"
            },
            slidesPerView: 5,  // ⚡️ Hiển thị 5 bài hát cùng lúc (chỉnh số tùy ý)
            spaceBetween: 20   // Khoảng cách giữa các phần tử
        });

    } catch (error) {
        console.error("Lỗi tải dữ liệu:", error);
    }
}

// Gọi API sau khi trang đã tải xong
document.addEventListener("DOMContentLoaded", fetchSongs);
