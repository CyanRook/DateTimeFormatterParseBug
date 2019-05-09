# DateTimeFormatterParseBug

DateTimeFormatter will not properly throw an exception in certain parsing cases.  

Per the spec, CLOCK_HOUR_OF_AMPM should throw a DateTimeParseException when the Hour value of the input string is 00.  

Per the spec, HOUR_OF_AMPM should throw a DateTimeParseException when the Hour value of the input string is 12.  

|      input             |   Parse Format     |   Expected             | Actual            |
|------------------------|--------------------|------------------------|-------------------|
|"2007-10-22 00:00 PM"   | HOUR_OF_AMPM       | 2007-10-22T12:00       | 2007-10-22T12:00  |
|"2007-10-22 00:00 PM"   | CLOCK_HOUR_OF_AMPM | DateTimeParseException | **2007-10-22T12:00** |
|"2007-10-22 12:00 PM"   | HOUR_OF_AMPM       | DateTimeParseException | **2007-10-23T00:00** |
|"2007-10-22 12:00 PM"   | CLOCK_HOUR_OF_AMPM | 2007-10-22T12:00       | 2007-10-22T12:00  |
