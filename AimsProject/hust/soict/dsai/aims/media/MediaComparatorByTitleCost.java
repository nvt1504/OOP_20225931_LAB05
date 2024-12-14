package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int titleComparison = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        if (titleComparison != 0) {
            return titleComparison; // Sắp xếp theo tiêu đề (chữ cái)
        }
        // Nếu tiêu đề giống nhau, sắp xếp theo giá giảm dần
        return Float.compare(m2.getPrice(), m1.getPrice());
    }
}
