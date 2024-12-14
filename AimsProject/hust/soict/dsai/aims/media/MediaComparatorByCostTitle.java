package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int costComparison = Float.compare(m2.getPrice(), m1.getPrice());
        if (costComparison != 0) {
            return costComparison; // Sắp xếp theo giá giảm dần
        }
        // Nếu giá giống nhau, sắp xếp theo tiêu đề (chữ cái)
        return m1.getTitle().compareToIgnoreCase(m2.getTitle());
    }
}
