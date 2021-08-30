package pl.wsikora.wseanalyzer.model;

public enum  Industry {
    GROCERIES("Artykuły spożywcze"),
    BANKS("Banki"),
    BIOTECHNOLOGY("Biotechnologia"),
    CONSTRUCTION("Budownictwo"),
    CHEMISTRY("Chemia"),
    WOOD_AND_PAPER("Drewno i papier"),
    HEAT_AND_WATER_DISTRIBUTION("Dystrybucja ciepła i wody"),
    DRUGS_DISTRIBUTION("Dystrybucja leków"),
    INVESTMENTS("Działalność inwestycyjna"),
    ENERGY("Energia"),
    MINING("Górnictwo"),
    GAMES("Gry"),
    RUBBER_AND_PLASTICS("Guma i tworzywa sztuczne"),
    WHOLESALE_TRADE("Handel hurtowy"),
    INTERNET_COMMERCE("Handel internetowy"),
    METALLURGY("Hutnictwo"),
    IT("Informatyka"),
    LEASING_AND_FACTORING("Leasing i faktoring"),
    MEDIA("Media"),
    AUTOMOTIVE("Motoryzacja"),
    REAL_ESTATE("Nieruchomości"),
    NEW_TECHNOLOGIES("Nowe technologie"),
    CLOTHING_AND_COSMETICS("Odzież i kosmetyki"),
    FUELS_AND_GAS("Paliwa i gaz"),
    FINANCIAL_INTERMEDIATION("Pośrednictwo finansowe"),
    OTHERS("Pozostałe"),
    DRUG_PRODUCTION("Produkcja leków"),
    ELECTROMECHANICAL_INDUSTRY("Przemysł elektromaszynowy"),
    RECYCLING("Recykling"),
    RECREATION_AND_RELAXATION("Rekreacja i wypoczynek"),
    CAPITAL_MARKET("Rynek kapitałowy"),
    COMMERCIAL_NETWORKS("Sieci handlowe"),
    MEDICAL_EQUIPMENT_AND_SUPPLIES("Sprzęt i materiały medyczne"),
    HOSPITALS_AND_CLINICS("Szpitale i przychodnie"),
    TELECOMMUNICATION("Telekomunikacja"),
    TRANSPORT_AND_LOGISTICS("Transport i logistyka"),
    INSURANCE("Ubezpieczenia"),
    BUSINESS_SERVICES("Usługi dla przedsiębiorstw"),
    RECEIVABLES("Wierzytelności"),
    HOME_FURNISHINGS("Wyposażenie domu"),
    ENTERPRISE_SUPPLIES("Zaopatrzenie przedsiębiorstw");
    private final String name;

    Industry(String name) {
        this.name = name;
    }

    public String getName() {
       return this.name();
    }

}
