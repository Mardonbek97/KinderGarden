CREATE OR REPLACE PACKAGE session_cache IS
  g_map hashmap_t;

  PROCEDURE init;
  PROCEDURE set_value(p_key VARCHAR2, p_value VARCHAR2);
  FUNCTION get_value(p_key VARCHAR2) RETURN VARCHAR2;
END;
/
CREATE OR REPLACE PACKAGE BODY session_cache IS

  PROCEDURE init IS
  BEGIN
    g_map := hashmap_t.constructor_hashmap();
  END;

  PROCEDURE set_value(p_key VARCHAR2, p_value VARCHAR2) IS
  BEGIN
    g_map.put(p_key, p_value);
  END;

  FUNCTION get_value(p_key VARCHAR2) RETURN VARCHAR2 IS
  BEGIN
    RETURN g_map.get(p_key);
  END;

END;
/
