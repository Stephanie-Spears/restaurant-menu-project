////<!-- Include jQuery -->
//  <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
//
//  <!-- Include Date Range Picker -->
//  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
//  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
//
//  <script>
//      $(document).ready(function(){
//          var date_input=$('input[name="date"]'); //our date input has the name "date"
//          var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
//          date_input.datepicker({
//              format: 'mm/dd/yyyy',
//              container: container,
//              todayHighlight: true,
//              autoclose: true,
//          })
//      })
//  </script>


//
///**
// * Parses the date from the string input.
// * @param {Number|Date|string} date Teh value to be parsed.
// * @param {Function|Date} [defaultValue] The default value to use if the date cannot be parsed.
// * @returns {Date} The parsed date value. If the date is invalid or can't be parsed, then the defaultValue is returned.
// */
//function parseDate(date, defaultValue) {
//  if (! date) return(getDefaultValue());
//  if (typeof(date) === 'date') return(date);
//  if (typeof(date) === 'number') return(new Date(date));
//
//  /**
//   * Gets the default value.
//   * @returns {Date}
//   */
//  function getDefaultValue() {
//    return((typeof(defaultValue) === 'function') ? defaultValue(name) : defaultValue);
//  }
//
//  var results;
//  // YYYY-MM-DD
//  if ((results = /(\d{4})[-\/\\](\d{1,2})[-\/\\](\d{1,2})/.exec(date))) {
//    return(new Date(results[1], parseInt(results[2], 10)-1, results[3]) || new Date(date) || getDefaultValue());
//  }
//  // MM/DD/YYYY
//  if ((results = /(\d{1,2})[-\/\\](\d{1,2})[-\/\\](\d{4})/.exec(date))) {
//    date = new Date(results[3], parseInt(results[1], 10)-1, results[2]) || new Date(date) || getDefaultValue();
//  }
//  return(new Date(date) || getDefaultValue());
//}