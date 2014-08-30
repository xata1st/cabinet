use db5;

INSERT INTO permissions (`ROLE`) VALUES("ROLE_USER");
INSERT INTO permissions (`ROLE`) VALUES("ROLE_ADMIN");

INSERT INTO groups (`GROUP_NAME`) VALUES("USER");
INSERT INTO groups (`GROUP_NAME`) VALUES("ADMIN");

INSERT INTO participants (`PART_NAME`, `PART_SURNAME`, `ADDRESS`) values("Bob", "Denilson", "New York"); 
INSERT INTO participants (`PART_NAME`, `PART_SURNAME`, `ADDRESS`) values("Jimi", "Hendrix", "Seatle");

