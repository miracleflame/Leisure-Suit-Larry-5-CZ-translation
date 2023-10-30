;;; Sierra Script 1.0 - (do not remove this comment)
(script# 460)
(include sci.sh)
(use Main)
(use LLRoom)
(use RTRandCycle)
(use ForwardCounter)
(use n958)
(use StopWalk)
(use Grooper)
(use Sound)
(use Cycle)
(use User)
(use PicView)
(use Obj)

(public
	rm460 0
)

(local
	local0
)
(instance rm460 of LLRoom
	(properties
		picture 460
	)
	
	(method (init)
		(proc958_0 129 470 465 1)
		(proc958_0
			128
			460
			461
			462
			470
			471
			551
			467
			570
			466
			1465
			1466
		)
		(proc958_0 132 470 464 461 462 463 465 466)
		(proc958_0 135 global175)
		(quayle init:)
		(desmond init:)
		(larry init: setCycle: Walk)
		(bigg init:)
		(pattiChair init:)
		(patDaisChair init:)
		(desDaisChair init:)
		(marilyn init:)
		(roger init:)
		(humphrey init:)
		(sleeper init:)
		(gLarry
			init:
			normalize: 462
			get: 13
			setCycle: 0
			setLoop: 4
			setCel: 0
			cycleSpeed: 5
			moveSpeed: 5
			posn: 131 127
			actions: pattiActions
		)
		(gLongSong number: 460 flags: 1 setLoop: -1 play:)
		(dinnerFX flags: 1 loop: -1 play:)
		(super init:)
		(proc0_13 480)
		(proc0_2)
		(global2 setScript: sCartoon)
	)
)

(instance sCartoon of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if local0 (Palette 6 243 255 -1))
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 2))
			(1
				(proc0_14 460 0 108 self 67 -1 20)
			)
			(2 (= ticks 30))
			(3
				(proc0_14 460 1 108 self 67 -1 185)
			)
			(4 (= ticks 30))
			(5
				(proc0_14 460 2 108 self 67 -1 15 70 280)
			)
			(6 (= ticks 30))
			(7
				(proc0_14 460 3 108 self 67 -1 15 70 280)
			)
			(8 (= ticks 30))
			(9
				(larry setMotion: MoveTo 300 157 self)
			)
			(10
				(proc0_14 460 4 67 -1 15 70 280)
				(proc0_14 460 5 67 -1 185)
				(larry setMotion: MoveTo 247 157 self)
			)
			(11
				(dinnerFX stop:)
				(gLongSong pause: 1)
				(gLongSong2 number: 470 flags: 1 setLoop: -1 play:)
				(proc0_18 gLarry 460 6 67 -1 20)
				(proc0_14 460 7 80 {Larry} 67 -1 185)
				(= cycles 1)
			)
			(12
				(larry
					setLoop: sGroop
					cycleSpeed: 4
					moveSpeed: 4
					setStep: 5 3
					setCycle: StopWalk -1
					setMotion: MoveTo 168 142 self
				)
				(= cycles 4)
			)
			(13
				(gLarry
					setPri: 10
					setCycle: CT (- (gLarry lastCel:) 1) 1 self
				)
			)
			(14
				(gLarry
					normalize:
					loop: 4
					posn: 129 130
					setPri: 10
					cycleSpeed: 4
					moveSpeed: 4
					setMotion: MoveTo 153 142
				)
			)
			(15
				(gLarry hide:)
				(pattiChair hide:)
				(desmond hide:)
				(patDaisChair hide:)
				(desDaisChair hide:)
				(quayle hide:)
				(bigg hide:)
				(larry hide:)
				(marilyn hide:)
				(roger hide:)
				(humphrey hide:)
				(sleeper hide:)
				(heart init:)
				(larryHead init:)
				(pattiHead init:)
				(pattiLeg init:)
				(global2 drawPic: 470)
				(= cycles 2)
			)
			(16 (= local0 1) (= seconds 3))
			(17
				(pattiLeg setCel: (pattiLeg lastCel:))
				(pattiHead setCycle: ForwardCounter 4)
				(proc0_18 gLarry 460 8 108 self 67 -1 185)
			)
			(18 (= ticks 30))
			(19
				(pattiHead setCycle: 0)
				(larryHead setCycle: ForwardCounter 5)
				(proc0_14 460 9 80 {Larry} 108 self 67 -1 185)
			)
			(20 (= ticks 30))
			(21
				(larryHead setCycle: 0)
				(pattiHead setCycle: ForwardCounter 5)
				(proc0_18 gLarry 460 10 108 self 67 -1 185)
			)
			(22 (= ticks 30))
			(23
				(pattiHead setCycle: 0)
				(larryHead setCycle: ForwardCounter 5)
				(proc0_14 460 11 80 {Larry} 108 self 67 -1 185)
			)
			(24 (= ticks 30))
			(25
				(larryHead setCycle: 0)
				(pattiHead setCycle: ForwardCounter 3)
				(proc0_18 gLarry 460 12 108 self 67 -1 185)
			)
			(26 (= ticks 30))
			(27
				(pattiHead setCycle: 0)
				(pattiLeg dispose:)
				(= seconds 3)
			)
			(28
				(heart dispose:)
				(larryHead dispose:)
				(pattiHead dispose:)
				(quayle show:)
				(bigg show:)
				(gLarry show: cycleSpeed: 6 moveSpeed: 6)
				(desmond
					show:
					cycleSpeed: 6
					moveSpeed: 6
					setLoop: 3
					setCel: 0
					posn: 238 132
				)
				(larry show: cycleSpeed: 6 moveSpeed: 6)
				(pattiChair show:)
				(desmondChair init:)
				(patDaisChair show:)
				(desDaisChair show:)
				(marilyn show:)
				(roger show:)
				(humphrey show:)
				(sleeper show:)
				(= local0 0)
				(global2 drawPic: 460)
				(gLongSong2 fade: 0 15 12 1 self)
			)
			(29
				(dinnerFX play:)
				(gLongSong pause: 0)
				(= seconds 3)
			)
			(30
				(proc0_18 gLarry 460 13 67 -1 20)
				(larry setHeading: 90 self)
			)
			(31
				(desmond
					setLoop: 4
					setCycle: Walk
					setMotion: MoveTo 194 147 self
				)
			)
			(32
				(proc0_14 460 14 80 {Larry} 67 -1 20)
				(proc0_14 460 15 67 -1 185 80 {Inspektor Desmond})
				(desmond setMotion: MoveTo 165 147 self)
			)
			(33
				(larry setHeading: 135 self)
			)
			(34
				(larry setHeading: 270)
				(gLarry normalize: setMotion: MoveTo -10 142)
				(desmond setMotion: MoveTo -10 147)
				(= ticks 120)
			)
			(35
				(larry setStep: 3 2 setMotion: MoveTo -10 139 self)
			)
			(36 (= seconds 5))
			(37
				(gLarry
					view: 462
					setLoop: 5
					setCycle: Walk
					x: -10
					y: 87
					setPri: 3
					setMotion: MoveTo 102 87 self
				)
				(desDaisChair setPri: 4)
				(= ticks 90)
			)
			(38
				(desmond setScript: sDesmondSits)
			)
			(39
				(gLarry
					setLoop: 6
					setCel: 0
					setCycle: 0
					setMotion: MoveTo 103 95 self
				)
			)
			(40
				(gLarry
					setLoop: 1
					setCel: 0
					setPri: 5
					cycleSpeed: 12
					x: 101
					y: 71
				)
				(= cycles 1)
			)
			(41
				(larry
					view: 551
					loop: 0
					setPri: 4
					x: -10
					y: 82
					setCycle: Walk
					setMotion: MoveTo 26 82 self
				)
			)
			(42 (= ticks 60))
			(43
				(larry view: 461 setLoop: 6 setCel: 2)
				(= ticks 45)
			)
			(44
				(larry setCycle: CT 1 1 self)
			)
			(45 (= ticks 45))
			(46
				(larry setCycle: CT 2 -1 self)
			)
			(47
				((larry looper?) dispose:)
				(= ticks 45)
			)
			(48
				(larry view: 551 setLoop: 0 setLoop: -1 setCycle: Walk)
				(= cycles 1)
			)
			(49
				(proc0_14 460 16 67 15 -1 70 280 80 {Larry})
				(= seconds 2)
			)
			(50
				(patDaisChair
					setLoop: 0
					setCel: 2
					setMotion: MoveTo (+ (patDaisChair x?) 3) (patDaisChair y?)
				)
				(gLarry setMotion: MoveTo 105 72 self)
			)
			(51 (= cycles 3))
			(52
				(desDaisChair
					setLoop: 0
					setCel: 2
					setMotion: MoveTo (+ (desDaisChair x?) 4) (desDaisChair y?)
				)
				(desmond setMotion: MoveTo 81 71 self)
			)
			(53 (= cycles 5))
			(54
				(patDaisChair
					setMotion: MoveTo (+ (patDaisChair x?) 4) (patDaisChair y?)
				)
				(gLarry setMotion: MoveTo 108 72 self)
			)
			(55
				(patDaisChair stopUpd:)
				(= cycles 3)
			)
			(56
				(desDaisChair
					setMotion: MoveTo (+ (desDaisChair x?) 3) (desDaisChair y?)
				)
				(desmond setMotion: MoveTo 86 71 self)
			)
			(57
				(desDaisChair stopUpd:)
				(gLarry setScript: sTalkDesmond)
				(ssguy init: setCycle: Walk setMotion: MoveTo 49 81 self)
			)
			(58
				(ssguy setLoop: 1 cycleSpeed: 10 setCycle: CT 5 1 self)
				(proc0_14 460 17)
			)
			(59
				(chairBack init:)
				(= cycles 1)
			)
			(60
				(ssguy setLoop: 1 setCycle: End self)
			)
			(61
				(ssguy
					setLoop: 2
					setCycle: Walk
					cycleSpeed: 6
					setPri: 0
					setMotion: MoveTo -50 81
				)
				(larry setMotion: MoveTo 64 82 self)
			)
			(62
				(larry setHeading: 180 self)
			)
			(63
				(larry
					loop: 2
					setCel: 0
					setCycle: 0
					setMotion: MoveTo 63 86 self
				)
			)
			(64
				(larry
					view: 461
					setLoop: 0
					setCel: 0
					setPri: 5
					cycleSpeed: 10
					x: 62
					y: 74
				)
				(= seconds 3)
			)
			(65
				(ssguy dispose:)
				(larry setCycle: End self)
			)
			(66
				(proc0_14 460 18 67 15 -1 70 280 80 {Larry})
				(= seconds 3)
			)
			(67
				(proc0_14 460 19 80 {Pan viceprezident})
				(proc0_14 460 20 80 {Larry})
				(larry setCycle: Beg self)
			)
			(68 (= seconds 3))
			(69
				(larry setLoop: 1 setCycle: End self)
			)
			(70 (= seconds 3))
			(71 (larry setCycle: Beg self))
			(72
				(sTalkDesmond dispose:)
				(= seconds 3)
			)
			(73 (bigg setCycle: End self))
			(74
				(gLarry setLoop: 0 setCycle: End self)
			)
			(75
				(proc0_14 460 21 67 -1 185)
				(= cycles 1)
			)
			(76
				(gLarry hide:)
				(pattiChair hide:)
				(desmondChair hide:)
				(desmond hide:)
				(patDaisChair hide:)
				(desDaisChair hide:)
				(quayle hide:)
				(bigg hide:)
				(larry hide:)
				(marilyn hide:)
				(roger hide:)
				(humphrey hide:)
				(sleeper hide:)
				(chairBack hide:)
				(global2 drawPic: 465)
				(dinnerFX stop:)
				(gLongSong number: 465 play:)
				(= seconds 3)
			)
			(77
				(proc0_18 Mr__Bigg 460 22 108 139 self)
			)
			(78
				(proc0_18 You 460 23 108 139 self)
			)
			(79
				(proc0_18 Mr__Bigg 460 24 139 self)
			)
			(80
				(proc0_18 Mr__Bigg 460 25 108 139 self)
			)
			(81 (= seconds 3))
			(82
				(proc0_14 460 26 67 -1 15 70 280)
				(proc0_14 460 27 67 -1 185)
				(= seconds 3)
			)
			(83
				(proc0_18 Mr__Bigg 460 28 67 -1 185 108 139 self)
			)
			(84
				(proc0_18 You 460 29 108 139 self)
			)
			(85
				(proc0_18 Mr__Bigg 460 30 67 -1 185 108 139 self)
			)
			(86 (= seconds 3))
			(87
				(proc0_14 460 31 67 -1 15 70 280)
				(proc0_14 460 32 67 -1 20)
				(= seconds 3)
			)
			(88
				(proc0_14 460 33 67 -1 185)
				(proc0_18 Mr__Bigg 460 34 108 139 self)
			)
			(89
				(proc0_14 460 35 67 -1 185)
				(= seconds 3)
			)
			(90
				(proc0_18 Mr__Bigg 460 36 139 self)
			)
			(91
				(proc0_18 Mr__Bigg 460 37 108 139 self)
			)
			(92
				(proc0_14 460 38 67 -1 15 70 280 108 self)
			)
			(93
				(proc0_18 You 460 39 108 139 self)
			)
			(94
				(proc0_18 Mr__Bigg 460 40 67 -1 185 108 139 self)
			)
			(95 (= seconds 3))
			(96
				(proc0_14 460 41 67 -1 20)
				(= seconds 3)
			)
			(97
				(gLarry show:)
				(pattiChair show:)
				(desmondChair show:)
				(desmond show:)
				(patDaisChair show:)
				(desDaisChair show:)
				(quayle show:)
				(bigg show:)
				(larry show:)
				(marilyn show:)
				(roger show:)
				(humphrey show:)
				(sleeper show:)
				(chairBack show:)
				(global2 drawPic: 460)
				(gLongSong number: 463 play:)
				(= ticks 60)
			)
			(98
				(gLarry setCycle: Beg)
				(bigg setCycle: Beg self)
			)
			(99
				(larry setLoop: 2 setCycle: End self)
			)
			(100 (= seconds 2))
			(101
				(proc0_14 460 42 80 {Larry} 67 -1 185 70 280)
				(proc0_18 gLarry 460 43)
				(proc0_14 460 44 80 {Pan Bigg})
				(proc0_18 gLarry 460 45 67 -1 185 70 280)
				(proc0_18 gLarry 460 46 67 -1 185 70 280)
				(proc0_14 460 47 80 {Pan Bigg})
				(proc0_14 460 48)
				(bigg setLoop: 1 setPri: 3 setCycle: End self)
			)
			(102
				(gLongSong number: 466 play:)
				(proc0_14 460 49 80 {Pan Bigg})
				(proc0_14 460 50 80 {Larry})
				(= cycles 1)
			)
			(103
				(marilyn setCycle: CT 8 1 self)
			)
			(104
				(pie init:)
				(marilyn setCycle: End self)
			)
			(105
				(larry
					setLoop: 3
					setCel: 0
					cycleSpeed: 10
					setCycle: CT 2 1 self
				)
			)
			(106
				(quayle hide:)
				(pie setPri: 5)
				(larry setCycle: End self)
			)
			(107
				(marilyn setLoop: 0 setCel: 0 setCycle: End self)
				(pieInFace play:)
			)
			(108
				(proc0_3)
				(User canControl: 0)
				(= seconds 6)
			)
			(109
				(proc0_14 460 51)
				(= seconds 6)
			)
			(110
				(global2 setScript: sCartoon2)
				(self dispose:)
			)
		)
	)
)

(instance sCartoon2 of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(proc0_14 460 52)
				(gLarry
					setLoop: 7
					cycleSpeed: 5
					setCel: 0
					setPri: 4
					setCycle: End self
				)
			)
			(1 (= ticks 30))
			(2
				(fireBra play:)
				(gLarry
					setLoop: 2
					cycleSpeed: 6
					setCel: 0
					setCycle: CT 2 1 self
				)
			)
			(3
				(bigg setLoop: 2 setCycle: End)
				(= cycles 5)
			)
			(4
				(fireBra play:)
				(gLarry setCycle: CT 5 1 self)
			)
			(5
				(gLongSong number: 461 setLoop: 1 play:)
				(gLarry
					setLoop: 3
					setCel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(6 (= ticks 180))
			(7
				(bigg hide:)
				(desmond
					x: 140
					y: 74
					setPri: 0
					setLoop: 1
					setCel: 0
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(8
				(desmond setLoop: 2 setCel: 0 setCycle: End self)
			)
			(9 (= ticks 180))
			(10
				(desmond
					cycleSpeed: 6
					setMotion: MoveTo (gLarry x?) 74 self
				)
			)
			(11
				(proc0_14 460 53 80 {Inspektor Desmond})
				(proc0_14 460 54 80 {Inspektor Desmond})
				(desmond cycleSpeed: 5 setMotion: MoveTo -50 74)
				(gLarry
					setMotion: MoveTo (gLarry x?) (+ (gLarry y?) 4) self
				)
			)
			(12
				(gLarry setLoop: 1 x: 108 y: 72 setPri: 5 setCel: 0)
				(gLongSong fade:)
				(= ticks 240)
			)
			(13
				(gLongSong number: 462 setVol: 127 setLoop: -1 play:)
				(larry setLoop: 4 setCel: 0 setCycle: End self)
			)
			(14
				(larry setLoop: 5 setCel: 0 setCycle: End self)
			)
			(15
				(pie setPri: 6)
				(larry setLoop: 0 setCel: 0 x: 62 y: 74)
				(quayle
					show:
					setLoop: 1
					setCel: 0
					x: 42
					y: 72
					setCycle: End self
				)
			)
			(16
				(proc0_14 460 55 80 {Larry})
				(quayle
					setLoop: 2
					setCel: 0
					posn: 38 71
					setCycle: End self
				)
			)
			(17 (= seconds 3))
			(18
				(larry setLoop: 1 setCel: 0 setCycle: End self)
			)
			(19
				(proc0_18 gLarry 460 56)
				(= ticks 90)
			)
			(20
				(quayle
					setLoop: 5
					setCel: 0
					posn: 42 72
					cycleSpeed: 11
					setCycle: End self
				)
			)
			(21 (= ticks 60))
			(22 (quayle setCycle: Beg self))
			(23
				(quayle
					setLoop: 3
					setCel: 0
					posn: 38 71
					cycleSpeed: 6
					setCycle: ForwardCounter 2 self
				)
			)
			(24
				(proc0_14 460 57 67 15 -1 70 280 80 {Pan viceprezident})
				(= cycles 1)
			)
			(25 (larry setCycle: Beg self))
			(26
				(larry setLoop: 0 setCycle: End self)
			)
			(27
				(proc0_14 460 58 80 {Larry})
				(= seconds 2)
			)
			(28
				(global2 drawPic: 1 6)
				(proc0_25 1 gLowlightColor_3 460 59)
				(= seconds 3)
			)
			(29
				(global2 newRoom: 480)
				(self dispose:)
			)
		)
	)
)

(instance sDesmondSits of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(desmond
					setLoop: 5
					x: -10
					y: 84
					setPri: 4
					setMotion: MoveTo 76 84 self
				)
			)
			(1
				(desmond
					setLoop: 6
					setCel: 0
					setCycle: 0
					setMotion: MoveTo 76 95 self
				)
				(desDaisChair setPri: 1)
			)
			(2
				(desmond setLoop: 0 setCel: 0 x: 76 y: 70 stopUpd:)
				(= cycles 1)
			)
			(3 (self dispose:))
		)
	)
)

(instance sTalkDesmond of Script
	(properties)
	
	(method (dispose)
		(if (desmond cel?) (desmond setCycle: Beg))
		(if (gLarry cel?) (gLarry setCycle: Beg))
		(super dispose: &rest)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 (= seconds 4))
			(1
				(desmond setCycle: End self)
				(gLarry setCycle: End)
			)
			(2 (= seconds 4))
			(3
				(gLarry setCycle: Beg)
				(desmond setCycle: Beg self)
			)
			(4 (self changeState: 0))
		)
	)
)

(instance sRogerSleeps of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(roger setCel: 0 setCycle: ForwardCounter 1 self)
			)
			(1 (= seconds (Random 3 5)))
			(2 (self changeState: 0))
			(3 (self dispose:))
		)
	)
)

(instance sHumphreyDrinks of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(humphrey setCel: 0 setCycle: ForwardCounter 1 self)
			)
			(1 (= seconds (Random 4 6)))
			(2 (self changeState: 0))
			(3 (self dispose:))
		)
	)
)

(instance sSleeperSleeps of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(sleeper setCel: 0 setCycle: ForwardCounter 1 self)
			)
			(1 (= seconds 3))
			(2 (self changeState: 0))
			(3 (self dispose:))
		)
	)
)

(instance larry of Actor
	(properties
		x 320
		y 157
		description {Larry Laffer}
		view 550
		loop 1
		signal $4001
		cycleSpeed 5
		moveSpeed 5
	)
)

(instance sGroop of Grooper
	(properties)
)

(instance pattiActions of Actions
	(properties)
	
	(method (doVerb theVerb param2)
		(return
			(if
				(or
					(and (== theVerb 4) (== param2 13))
					(and (== theVerb 3) (proc0_6 35))
				)
				(proc0_10 100)
				(global2 setScript: sCartoon2)
				(return 1)
			else
				(return 0)
			)
		)
	)
)

(instance desmond of Actor
	(properties
		x 225
		y 127
		description {Desmond}
		view 464
		loop 3
		cel 1
		signal $4001
	)
)

(instance desmondChair of View
	(properties
		x 236
		y 127
		description {køeslo}
		view 460
		cel 1
		signal $4001
	)
)

(instance pattiChair of View
	(properties
		x 120
		y 127
		description {køeslo}
		view 460
		signal $4001
	)
)

(instance roger of Prop
	(properties
		x 139
		y 144
		description {Roger}
		view 460
		loop 1
		priority 14
		signal $4010
		cycleSpeed 24
		detailLevel 1
	)
	
	(method (init)
		(super init:)
		(self setScript: sRogerSleeps)
	)
)

(instance humphrey of Prop
	(properties
		x 139
		y 101
		description {Humphrey}
		view 460
		loop 3
		priority 10
		signal $4010
		cycleSpeed 12
		detailLevel 2
	)
	
	(method (init)
		(super init:)
		(self setScript: sHumphreyDrinks)
	)
)

(instance sleeper of Prop
	(properties
		x 224
		y 169
		description {spící host}
		view 460
		loop 2
		priority 14
		signal $4010
		cycleSpeed 24
		detailLevel 3
	)
	
	(method (init)
		(super init:)
		(self setScript: sSleeperSleeps)
	)
)

(instance ssguy of Actor
	(properties
		x -50
		y 81
		description {muž z tajné služby}
		view 466
		priority 4
		signal $4011
	)
)

(instance quayle of Prop
	(properties
		x 40
		y 74
		description {viceprezident}
		view 463
		priority 5
		signal $0011
	)
	
	(method (init)
		(self setCycle: Fwd)
		(super init: &rest)
	)
)

(instance bigg of Prop
	(properties
		x 140
		y 74
		description {Pan Bigg}
		view 465
		priority 5
		signal $4011
		cycleSpeed 10
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(4
				(switch param2
					(13
						(proc0_10 100)
						(global2 setScript: sCartoon2)
					)
					(else 
						(super doVerb: theVerb param2 &rest)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance pattiHead of Prop
	(properties
		x 158
		y 74
		view 471
		priority 5
		signal $0010
	)
)

(instance larryHead of Prop
	(properties
		x 176
		y 84
		view 471
		loop 1
		priority 5
		signal $0010
	)
)

(instance heart of Prop
	(properties
		x 176
		y 132
		view 470
		signal $0010
	)
	
	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance pattiLeg of Prop
	(properties
		x 132
		y 149
		view 471
		loop 2
	)
)

(instance chairBack of Actor
	(properties
		x 61
		y 71
		description {køeslo}
		view 460
		cel 3
		signal $4001
	)
)

(instance desDaisChair of Actor
	(properties
		x 75
		y 70
		description {køeslo}
		view 460
		cel 2
		signal $4001
	)
)

(instance patDaisChair of Actor
	(properties
		x 101
		y 70
		description {køeslo}
		view 460
		cel 2
		signal $4001
	)
)

(instance marilyn of Prop
	(properties
		x 14
		y 75
		description {Marilyn Quayle}
		view 467
		loop 1
		priority 5
		signal $4011
		cycleSpeed 10
	)
)

(instance pie of View
	(properties
		x 37
		y 74
		description {koláè}
		view 463
		loop 4
		priority 6
		signal $4011
	)
)

(instance dinnerFX of Sound
	(properties
		number 467
	)
)

(instance pieInFace of Sound
	(properties
		number 464
		priority 15
	)
)

(instance fireBra of Sound
	(properties
		number 434
	)
)

(instance Mr__Bigg of Talker
	(properties
		x 20
		y 185
		nsTop 60
		nsLeft 150
		view 1466
		loop 3
		talkWidth 280
		name "Pan Bigg"
	)
	
	(method (init)
		(= mouth biggMouth)
		(super init: &rest)
	)
)

(instance biggMouth of Prop
	(properties
		nsTop 8
		nsLeft 6
		view 1466
		cycleSpeed 5
	)
)

(instance You of Talker
	(properties
		x 20
		y 5
		nsTop 70
		nsLeft 100
		view 1465
		loop 3
		talkWidth 160
	)
	
	(method (init)
		(= mouth pattiMouth)
		(= eyes pattiEyes)
		(super init: &rest)
	)
)

(instance pattiMouth of Prop
	(properties
		nsTop 9
		nsLeft 4
		view 1465
		cycleSpeed 5
	)
)

(instance pattiEyes of Prop
	(properties
		nsTop 1
		nsLeft 8
		view 1465
		loop 2
		cycleSpeed 5
	)
)
