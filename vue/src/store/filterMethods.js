export function getByNoiseLevel(noiseLevel, list) {
    return list.filter(list => list.noise_rating == noiseLevel)
}

export function getByMoneyLevel(moneyLevel, list) {
    return list.filter(list => list.cost_rating == moneyLevel)
}

export function getByKeyword(list) {
    return list.filter()
}