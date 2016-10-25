(ns euler.problem19)

; Counting Sundays
; Problem 19

; You are given the following information, but you may prefer to do some research for yourself.

;     - 1 Jan 1900 was a Monday.
;     - Thirty days has September,
;       April, June and November.
;       All the rest have thirty-one,
;       Saving February alone,
;       Which has twenty-eight, rain or shine.
;       And on leap years, twenty-nine.
;     - A leap year occurs on any year evenly divisible by 4, but not on a century 
;       unless it is divisible by 400.

; How many Sundays fell on the first of the month during the twentieth century 
; (1 Jan 1901 to 31 Dec 2000)?

(defn leap? [year]
  (cond 
    (not= (mod year 4) 0) false
    (not= (mod year 100) 0) true
    (not= (mod year 400) 0) false
    :else true))

(def regular-month-days 
  (sorted-map 1  31, 3  31, 4  30, 5 31, 
              6  30, 7  31, 8  31, 9 30, 
              10 31, 11 30, 12 31))

(defn month-days [year] 
  (assoc regular-month-days 2 (if (leap? year) 29 28)))

(def calendar
    (map assoc 
      (for [year  (range 1900 2001) 
            month (keys (month-days year))
            day   (range 1 (inc ((month-days year) month)))]
        {:year year :month month :day day})
      (repeat :dow)  
      (cycle ['Mon 'Tue 'Wed 'Thu 'Fri 'Sat 'Sun])))

(def sundays 
  (for [date calendar 
        :when (< 1900 (:year date)) 
        :when (= (:day date) 1) 
        :when (= (:dow date) 'Sun)]
    date))
    
(def problem19 (count sundays))
