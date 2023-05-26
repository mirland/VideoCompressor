package numan.dev.videocompressor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class VideoCompressor {
    public static void convertVideo(String srcPath, String destPath, int outputWidth, int outputHeight, int bitrate, ProgressListener listener) {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                listener.onStart();
                VideoController.getInstance()
                        .convertVideo(srcPath, destPath, outputWidth, outputHeight, bitrate, listener::onProgress);
                listener.onFinish(true);
            } catch (Exception e) {
                listener.onError(e.getMessage());
            }
        });
    }


    public static interface ProgressListener {
        void onStart();

        void onFinish(boolean result);

        void onProgress(float progress);

        void onError(String errorMessage);
    }

}
