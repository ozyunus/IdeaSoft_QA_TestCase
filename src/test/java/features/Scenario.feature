Feature: TestCase
  Scenario: Sepete ürün ekleme ve sepet kontrolü
    Given Web sayfasına git
    And Arama alanına tıkla
    And "ürün" yaz
    When Enter tuşuna bas
    Then Ürün'ün listelendiğini gör. Assert True ürün
    And Scroll page

    Given Ürün detay sayfasına git
    And Ürün adedini 5 yap
    When Sepete 5 adet ekle
    Then Sepete Eklendi metnini yakala. Assert True

    Given Sepet sayfasına git
    Then Sepete gidip 5 ürün eklendiğini doğrula.
