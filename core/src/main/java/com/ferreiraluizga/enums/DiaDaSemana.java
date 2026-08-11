package com.ferreiraluizga.enums;

import java.time.DayOfWeek;

public enum DiaDaSemana {
    SEGUNDAFEIRA, TERCAFEIRA, QUARTAFEIRA, QUINTAFEIRA, SEXTAFEIRA;

    public static DiaDaSemana fromJavaDayOfWeek(DayOfWeek dayOfWeek) {
        return switch (dayOfWeek) {
            case MONDAY -> SEGUNDAFEIRA;
            case TUESDAY -> TERCAFEIRA;
            case WEDNESDAY -> QUARTAFEIRA;
            case THURSDAY -> QUINTAFEIRA;
            case FRIDAY -> SEXTAFEIRA;
            default -> throw new IllegalArgumentException("Finais de semana não são permitidos: " + dayOfWeek);
        };
    }

    public DayOfWeek toJavaDayOfWeek() {
        return switch (this) {
            case SEGUNDAFEIRA -> java.time.DayOfWeek.MONDAY;
            case TERCAFEIRA -> java.time.DayOfWeek.TUESDAY;
            case QUARTAFEIRA -> java.time.DayOfWeek.WEDNESDAY;
            case QUINTAFEIRA -> java.time.DayOfWeek.THURSDAY;
            case SEXTAFEIRA -> java.time.DayOfWeek.FRIDAY;
        };
    }
}
