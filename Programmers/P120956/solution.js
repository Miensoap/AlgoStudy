const available = ["aya", "ye", "woo", "ma"];

function solution(babbling) {
  const pattern = new RegExp(`^(${available.join("|")})+$`);
  return babbling.filter((say) => pattern.test(say)).length;
}
