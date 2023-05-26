### Would you like to support me?

<a href="https://www.buymeacoffee.com/numan.dev" target="_blank"><img src="https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png" alt="Buy Me A Coffee" style="height: auto !important;width: auto !important;" ></a>

---

# VideoCompressor
A High-performance video compressor for Android using Hardware decoding and encoding API(MediaCodec).

## Demo
![Demo](/pic/Demo.gif)

## Usage
```


import numan.dev.videocompressor.VideoCompressor;

  /**
   * @param srcPath     string, filepath of source file
   * @param destPath    string, ouput filepath
   * @param outputWidth  pixels, output video width
   * @param outputHeight pixels, output video height
   * @param bitrate  int, in bits per second
   * @param listener  the listenr of convert progress
   */
VideoCompressTask task = VideoCompressor.convertVideo(srcPath, destPath, 200, 360, 200 * 360 * 30, new new VideoCompressor.ProgressListener() {
    @Override
    public void onStart() {
        //Start Compress
    }

    @Override
    public void onFinish() {
        //Finish successfully
    }

    @Override
    public void onError(String errorMessage) {
        promise.resolve(srcPath);
    }

    @Override
    public void onProgress(float percent) {
        //Progress
    }
});

// for cancel compression
task.cancel(true);
```

## Performance
You can find some test results in pic/test_reports.

I compress a video which is 168MB(00:01:06). 

And it took 1 minute for compressing.

The result of compressing is 11MB. 

So it's a great job by MediaCodec :) .

## React Native

[react-native-compressor](https://www.npmjs.com/package/react-native-compressor)

## License
```
Copyright 2017 Numan

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

**Note: it is a fork from fishwjy/VideoCompressor**
