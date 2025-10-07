CREATE OR REPLACE Type Hashmap_t as Object
(
  key   sys.odcivarchar2list,
  value sys.odcivarchar2list,

  member procedure put(p_key varchar2, p_value varchar2),
  member function get(p_key varchar2) return varchar2,
  member procedure remove(p_key varchar2),
  member procedure clear,
  member function keyset return sys.odcivarchar2list

)
/
CREATE OR REPLACE Type Body Hashmap_t IS

  member procedure put(p_key varchar2, p_value varchar2) is
  begin
    
    --If any keys found then value updated to new one
    for i in 1 .. nvl(self.key.count, 0) loop
      if self.key(i) = p_key then
        self.value(i) := p_value;  
        return;
      end if;
    end loop;


    self.key.extend;
    self.value.extend;
    self.key(self.key.last) := p_key;
    self.value(self.value.last) := p_value;
    
  end;

  member function get(p_key varchar2) return varchar2 is
  begin
    for i in 1 .. self.key.count loop
      if self.key(i) = p_key then
        return self.value(i);
      end if;
    end loop;
    return null;
  end;
  
  member procedure remove(p_key varchar2) is
    v_cnt pls_integer;
  begin
    if self.key is null or nvl(self.key.count,0) = 0 then
      return;
    end if;

    v_cnt := self.key.count;

    for i in 1 .. v_cnt loop
      if self.key(i) = p_key then
        if i < v_cnt then
          for j in i .. v_cnt - 1 loop
            self.key(j)   := self.key(j + 1);
            self.value(j) := self.value(j + 1);
          end loop;
        end if;
        self.key.trim;
        self.value.trim;
        exit;
      end if;
    end loop;
  end;
  
  member procedure clear is
  begin
    self.key.delete;
    self.value.delete;
  end;

  
  member function keyset return sys.odcivarchar2list is
  begin
    return self.key;
  end;

End;
/
