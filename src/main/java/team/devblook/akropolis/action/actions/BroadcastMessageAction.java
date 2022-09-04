/*
 * This file is part of Akropolis
 *
 * Akropolis free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Akropolis is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Akropolis. If not, see <http://www.gnu.org/licenses/>.
 */

package team.devblook.akropolis.action.actions;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import team.devblook.akropolis.AkropolisPlugin;
import team.devblook.akropolis.action.Action;
import team.devblook.akropolis.util.PlaceholderUtil;

public class BroadcastMessageAction implements Action {

    @Override
    public String getIdentifier() {
        return "BROADCAST";
    }

    @Override
    public void execute(AkropolisPlugin plugin, Player player, String data) {
        Component parsedData = PlaceholderUtil.setPlaceholders(data, player);

        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage(parsedData);
        }
    }
}
