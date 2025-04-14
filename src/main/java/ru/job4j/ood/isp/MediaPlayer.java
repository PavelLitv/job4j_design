package ru.job4j.ood.isp;

public interface MediaPlayer {
    void playAudio();

    void playVideo();

    class AudioPlayer implements MediaPlayer {
        @Override
        public void playAudio() {
            System.out.println("Playing audio");
        }

        @Override
        public void playVideo() {
            throw new UnsupportedOperationException("No video support");
        }
    }

    class VideoPlayer implements MediaPlayer {
        @Override
        public void playAudio() {
            throw new UnsupportedOperationException("No audio support");
        }

        @Override
        public void playVideo() {
            System.out.println("Playing video");
        }
    }
}
/*
Интерфейс MediaPlayer нарушает принцип ISP, т.к. классы зависят от методов, которые им не нужны
 */
