(ns start-figwheel-uix.server
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [hiccup.page :refer [html5 include-js include-css]]
            [ring.util.response :refer [not-found]]))

(defn index-html []
  (html5
   [:head
    [:meta {:charset "UTF-8"}]
    [:meta {:name "viewport"
            :content "width=device-width, initial-scale=1"}]
    [:title "Figwheel Starter"]
    (include-css "/css/main.css")]
   [:body
    [:h1 "figwheel-main + UIX"]
    [:div {:id "app"}]
    (include-js "/cljs-out/dev-main.js")
    [:script "start_figwheel_uix.core.init();"]]))

(defn devcards-html []
  (html5
   [:head
    [:meta {:charset "UTF-8"}]
    [:meta {:name "viewport"
            :content "width=device-width, initial-scale=1"}]
    [:title "Devcards"]]
   [:body
    [:div {:id "app-devcards"}]
    (include-js "/cljs-out/dev-main-devcards.js")]))

(defroutes handler
  (GET "/" [] (index-html))
  (GET "/devcards" [] (devcards-html))
  (route/not-found (not-found "Not found")))
