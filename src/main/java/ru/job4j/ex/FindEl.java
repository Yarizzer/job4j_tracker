package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Item not found");
        }
        return rsl;
    }

    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        /* if contains throw ElementAbuseException */
        for (String item : abuses) {
            if (value.equals(item)) {
                throw new ElementAbuseException("abuses contains " + value);
            }
        }
        return true;
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        } catch (ElementAbuseException ea) {
            ea.printStackTrace();
        } catch (ElementNotFoundException en) {
            en.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
