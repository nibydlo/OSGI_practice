package com.krylov.osgi.command;

import com.krylov.osgi.common.MediaPortal;
import org.apache.felix.service.command.CommandProcessor;
import org.osgi.service.component.annotations.*;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.joining;

@Component(
        service = CommandStat.class,
        immediate = true,
        property = {
                CommandProcessor.COMMAND_SCOPE + ":String=news",
                CommandProcessor.COMMAND_FUNCTION + ":String=stats"
        }
)
public class CommandStat {

    Map<String, MediaPortal> mediaPortalMap = new HashMap<String, MediaPortal>();


    @Reference(
            service = MediaPortal.class,
            cardinality = ReferenceCardinality.MULTIPLE,
            policy = ReferencePolicy.DYNAMIC,
            unbind = "unbinder"
    )
    public void binder(MediaPortal mediaPortal) {
        System.out.println(mediaPortal.getMediaName());
        mediaPortalMap.put(mediaPortal.getMediaName(), mediaPortal);
    }

    public void unbinder(MediaPortal mediaPortal) {
        System.out.println("Unbind " + mediaPortal.getMediaName());
        mediaPortalMap.remove(mediaPortal.getMediaName());
    }

    public void stats() {
        System.out.println("Expected \"news:stats <media_name>\"");
        System.out.println("<media_name> can be: " + mediaPortalMap.keySet().stream().collect(joining(", ")));
    }

    public void stats(String mediaName) {
        if (mediaPortalMap.containsKey(mediaName)) {
            System.out.println(mediaPortalMap.get(mediaName).getTopWords());
        } else {
            System.out.println("<media_name> can be: " + mediaPortalMap.keySet().stream().collect(joining(", ")));
        }
    }
}
