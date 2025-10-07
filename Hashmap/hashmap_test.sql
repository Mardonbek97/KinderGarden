DECLARE
  m hashmap_t := hashmap_t(SYS.ODCIVARCHAR2LIST(), SYS.ODCIVARCHAR2LIST());
BEGIN

  session_cache.init;

  session_cache.set_value('A', 'Apple');
  session_cache.set_value('B', 'Banana');
  session_cache.set_value('C', 'Cherry');

END;
/

  Select session_cache.get_value('B') val from dual
