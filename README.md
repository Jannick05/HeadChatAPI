# HeadChatAPI

## Description

HeadChatAPI is a utility class written in Java that allows you to retrieve an 8x8 pixel player head image of a Minecraft user. It fetches the player head from the Cravatar.eu service and provides methods to obtain the pixel data as a list of strings.

## Usage

### `getFace(String name)`

This method retrieves the player head image of the Minecraft user with the specified name.

**Parameters:**
- `name` (String): The username of the Minecraft user whose head image you want to retrieve.

**Returns:**
- `List<String>`: A list of strings representing the pixel data of the player head image.

### `getFace(File img)`

This method retrieves the player head image from a local file.

**Parameters:**
- `img` (File): The file object representing the image file.

**Returns:**
- `List<String>`: A list of strings representing the pixel data of the player head image.

## Example

```java
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        List<String> pixelData = HeadChatAPI.getFace("username");
        for (String line : pixelData) {
            event.getPlayer().sendMessage(line);
        }
    }
}
```
Hex Code format used in code is `<#RRGGBB>`, you can change this inside the class.


![Example](https://imgur.com/oEzVQRT.png)
