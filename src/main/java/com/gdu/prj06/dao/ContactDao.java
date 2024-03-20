package com.gdu.prj06.dao;

import com.gdu.prj06.dto.ContactDto;

import java.util.List;

public interface ContactDao {
  int registerContact(ContactDto contact);
  int modifyContact(ContactDto contact);
  int removeContact(int contactNo);
  List<ContactDto> getContactList();
  ContactDto getContactByNo(int contactNo);
}
