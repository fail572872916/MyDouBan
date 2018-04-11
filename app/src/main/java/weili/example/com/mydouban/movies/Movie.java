package weili.example.com.mydouban.movies;

import java.util.List;

/**
 * @author Administrator
 * @name IDouBan
 * @class describe
 * @time 2018-04-11 9:31
 */
public class Movie {

        /**
         * rating : {"max":10,"average":8.9,"stars":"45","min":0}
         * genres : ["动作","科幻","冒险"]
         * title : 头号玩家
         * casts : [{"alt":"https://movie.douban.com/celebrity/1328390/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1464678182.3.webp","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1464678182.3.webp","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1464678182.3.webp"},"name":"泰伊·谢里丹","id":"1328390"},{"alt":"https://movie.douban.com/celebrity/1327806/","avatars":{"small":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p8u95Rxw3ebIcel_avatar_uploaded1365073023.28.webp","large":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p8u95Rxw3ebIcel_avatar_uploaded1365073023.28.webp","medium":"http://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p8u95Rxw3ebIcel_avatar_uploaded1365073023.28.webp"},"name":" 奥利维亚·库克","id":"1327806"},{"alt":"https://movie.douban.com/celebrity/1000248/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5681.webp","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5681.webp","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5681.webp"},"name":"本·门德尔森","id":"1000248"}]
         * collect_count : 343401
         * original_title : Ready Player One
         * subtype : movie
         * directors : [{"alt":"https://movie.douban.com/celebrity/1054440/","avatars":{"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34602.webp","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34602.webp","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34602.webp"},"name":"史蒂文·斯皮尔伯格","id":"1054440"}]
         * year : 2018
         * images : {"small":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2516578307.webp","large":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2516578307.webp","medium":"http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2516578307.webp"}
         * alt : https://movie.douban.com/subject/4920389/
         * id : 4920389
         */

        private RatingBean rating;
        private String title;
        private int collect_count;
        private String original_title;
        private String subtype;
        private String year;
        private ImagesBean images;
        private String alt;
        private String id;
        private List<String> genres;
        private List<CastsBean> casts;
        private List<DirectorsBean> directors;

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCollect_count() {
            return collect_count;
        }

        public void setCollect_count(int collect_count) {
            this.collect_count = collect_count;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getGenres() {
            return genres;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public List<CastsBean> getCasts() {
            return casts;
        }

        public void setCasts(List<CastsBean> casts) {
            this.casts = casts;
        }

        public List<DirectorsBean> getDirectors() {
            return directors;
        }

        public void setDirectors(List<DirectorsBean> directors) {
            this.directors = directors;
        }

        public static class RatingBean {
            /**
             * max : 10
             * average : 8.9
             * stars : 45
             * min : 0
             */

            private int max;
            private double average;
            private String stars;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public double getAverage() {
                return average;
            }

            public void setAverage(double average) {
                this.average = average;
            }

            public String getStars() {
                return stars;
            }

            public void setStars(String stars) {
                this.stars = stars;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class ImagesBean {
            /**
             * small : http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2516578307.webp
             * large : http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2516578307.webp
             * medium : http://img3.doubanio.com/view/photo/s_ratio_poster/public/p2516578307.webp
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }

        public static class CastsBean {
            /**
             * alt : https://movie.douban.com/celebrity/1328390/
             * avatars : {"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1464678182.3.webp","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1464678182.3.webp","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1464678182.3.webp"}
             * name : 泰伊·谢里丹
             * id : 1328390
             */

            private String alt;
            private AvatarsBean avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBean getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBean avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsBean {
                /**
                 * small : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1464678182.3.webp
                 * large : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1464678182.3.webp
                 * medium : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1464678182.3.webp
                 */

                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }

        public static class DirectorsBean {
            /**
             * alt : https://movie.douban.com/celebrity/1054440/
             * avatars : {"small":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34602.webp","large":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34602.webp","medium":"http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34602.webp"}
             * name : 史蒂文·斯皮尔伯格
             * id : 1054440
             */

            private String alt;
            private AvatarsBeanX avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBeanX getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBeanX avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsBeanX {
                /**
                 * small : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34602.webp
                 * large : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34602.webp
                 * medium : http://img7.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34602.webp
                 */

                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }


}
