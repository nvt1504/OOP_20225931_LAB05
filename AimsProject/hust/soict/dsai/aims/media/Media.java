    package hust.soict.dsai.aims.media;

    public abstract class Media {
        private final int id;             // Mã định danh không thay đổi
        private final String title;       // Tiêu đề không thay đổi
        private final String category;    // Danh mục không thay đổi
        private final float price;        // Giá không thay đổi

        public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
        public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();


        // Constructor
        public Media(int id, String title, String category, float price) {
            if (id < 0) throw new IllegalArgumentException("ID must be a non-negative integer.");
            if (title == null || title.isEmpty()) throw new IllegalArgumentException("Title cannot be null or empty.");
            if (category == null || category.isEmpty()) throw new IllegalArgumentException("Category cannot be null or empty.");
            if (price < 0) throw new IllegalArgumentException("Price must be a non-negative value.");

            this.id = id;
            this.title = title;
            this.category = category;
            this.price = price;
        }

        // Getters
        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getCategory() {
            return category;
        }

        public float getPrice() {
            return price;
        }

        // Override equals() method to compare Media objects by title
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true; // Kiểm tra tham chiếu
            if (obj == null || getClass() != obj.getClass()) return false; // Kiểm tra kiểu đối tượng
            Media media = (Media) obj; // Ép kiểu
            return title.equalsIgnoreCase(media.title); // So sánh tiêu đề (không phân biệt chữ hoa/chữ thường)
        }

        // Override hashCode() to be consistent with equals()
        @Override
        public int hashCode() {
            return title.toLowerCase().hashCode();
        }
        @Override
        public String toString() {
            return "Media[ID=" + id + ", Title=" + title + ", Category=" + category + ", Price=" + price + "]";
        }

    }
