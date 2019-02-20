package com.krylov.osgi;

import java.util.List;

public interface MediaPortal {

    int WORDS_COUNT = 10;

    String getMediaName();

    List<String> getNewsNames();

    List<String> getTopWords();
}
