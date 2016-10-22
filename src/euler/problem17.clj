(ns euler.problem17
   (:require [clojure.string :as str]))
   
; Number letter counts
; Problem 17

; If the numbers 1 to 5 are written out in words: one, two, three, four, five, 
; then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

; If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, 
; how many letters would be used?

; NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) 
; contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. 
; The use of "and" when writing out numbers is in compliance with British usage.



(def digits-and-teens 
  (sorted-map
    1 "one" 2 "two" 3 "three" 4 "four" 5 "five" 
    6 "six" 7 "seven" 8 "eight" 9 "nine" 10 "ten" 
    11 "eleven" 12 "twelve" 13 "thirteen" 14 "fourteen" 
    15 "fifteen" 16 "sixteen" 17 "seventeen" 
    18 "eighteen" 19 "nineteen"))

(def tens { 2 "twenty" 3 "thirty" 4 "forty" 5 "fifty" 
            6 "sixty" 7 "seventy" 8 "eighty" 9 "ninety"})

(def hundreds 
  (into {} 
        (for [[k v] digits-and-teens :when (< k 10)] 
          [k (str v "hundred")])))

(def thousands 
  (into {} 
        (for [[k v] digits-and-teens :when (< k 10)] 
          [k (str v "thousand")])))

(def pos-idx {1 digits-and-teens 2 tens 3 hundreds 4 thousands})
    
(defn- parse-num-seq [num-seq accum]
  (let [c (count num-seq)
        f (first num-seq)]
    (if (or (= c 1) (and (= c 2) (= 1 f)))
      (conj accum (digits-and-teens (Integer/parseInt (apply str num-seq))))
      (if (and (= c 3) (not= [0 0] (rest num-seq)))
        (parse-num-seq (rest num-seq) (conj accum (str ((pos-idx c) f) "and")))
        (parse-num-seq (rest num-seq) (conj accum ((pos-idx c) f)))))))

(defn- split-number [n]
  (->> 
    (-> n
        str
        (str/split #""))
    (map #(Integer/parseInt %))))

(defn written-number [n]
  (parse-num-seq (split-number n) []))

(def problem17 
  (-> 
    (range 1 1001) 
    (#(map written-number %)) 
    flatten 
    (#(apply str %)) 
    count))
