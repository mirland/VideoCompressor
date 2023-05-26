package numan.dev.videocompressor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VideoCompressor {
    public static ExecutorService convertVideo(String srcPath, String destPath, int outputWidth, int outputHeight, int bitrate, ProgressListener listener) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                listener.onStart();
                VideoController.getInstance()
                        .convertVideo(srcPath, destPath, outputWidth, outputHeight, bitrate, listener::onProgress);
                listener.onFinish(true);
            } catch (Exception e) {
                listener.onError(e.getClass().toString());
            }
            executor.shutdown();
        });
        return executor;
    }


    public static interface ProgressListener {
        void onStart();

        void onFinish(boolean result);

        void onProgress(float progress);

        void onError(String errorMessage);
    }

}
