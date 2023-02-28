import java.util.*;


public class ex2 {
    public static void main(String[] args) {
        Map<String, Integer> name_map = new HashMap<>();
        String employees = "Иван Иванов " +
                "Светлана Петрова " +
                "Кристина Белова " +
                "Анна Мусина " +
                "Анна Крутова " +
                "Иван Юрин " +
                "Петр Лыков " +
                "Павел Чернов " +
                "Петр Чернышов " +
                "Мария Федорова " +
                "Марина Светлова " +
                "Мария Савина " +
                "Мария Рыкова " +
                "Марина Лугова " +
                "Анна Владимирова " +
                "Иван Мечников " +
                "Петр Петин " +
                "Иван Ежов ";
        String[] names_list = employees.split(" ");
        for (int i = 0; i < names_list.length; i += 2) {
            if (name_map.containsKey(names_list[i])) {
                name_map.replace(names_list[i], name_map.get(names_list[i]) + 1);
            } else {
                name_map.put(names_list[i], 1);
            }
        }
        
        Map<String, Integer> sorted = new LinkedHashMap<>();
        int max = 1;
        for (int value : name_map.values()) {
            if (value > max) {
                max = value;
            }
        }
        for (int j = max; j > 0; j--) {
            for (Map.Entry<String, Integer> entry : name_map.entrySet()) {
                String key = entry.getKey();
                if (name_map.get(key) == j) {
                    sorted.put(key, name_map.get(key));                  
                }
            }            
        }
        System.out.println(sorted);
    }
}

